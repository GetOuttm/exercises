package com.up.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testFileupload1")
    public String testFileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");

        //使用fileupload组件完成文件上传
        //上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明普通的表单项
            } else {
                //说明是上传文件项
                //获取上传文件的名称
                String filename = item.getName();

                //把文件名设置成唯一的值，UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "-" + filename;

                //完成文件上传
                item.write(new File(realPath, filename));
                //删除临时文件   大于10kb会有临时文件  小于10kb会有缓存
                item.delete();
            }

            System.out.println(item);
        }
        return "success";
    }


    @RequestMapping("testSpringMVCFileupload")
    public String testSpringMVCFileupload(MultipartFile upload, HttpServletRequest request) throws Exception {
        System.out.println("springmvc文件上传");

        //使用fileupload组件完成文件上传
        //上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //说明是上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();

        //把文件名设置成唯一的值，UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "-" + filename;

        //完成文件上传
        upload.transferTo(new File(realPath,filename));

        System.out.println(filename);
        return "success";
    }

    /**
     * SpringMVC跨服务器文件上传
     *  http://localhost:8080   应用服务器
     * http://localhost:9090  图片服务器，存储图片
     * @throws Exception
     */
    @RequestMapping("testSpringMVCFileupload1")
    public String testSpringMVCFileupload1(MultipartFile upload) throws Exception {
        System.out.println("springmvc跨服务器文件上传");

        //定义上传文件服务器路径
        String path = "http://localhost:9090/uploads/";

        //说明是上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();

        //把文件名设置成唯一的值，UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "-" + filename;

        //完成文件上传，跨服务器上传
        //1.创建客户端对象
        Client client = Client.create();

        //2.和文件服务器进行连接
        WebResource resource = client.resource(path + filename);

        //3.上传文件
        resource.put(upload.getBytes());

        /**
         * 如果运行出现403错误进去tomcat服务器的conf/web.xml进行
         * 打开文件服务器下的此文件，然后搜索readonly这个单词，可以看到这段注释代码：
         * <!--   readonly            Is this context "read only", so HTTP       -->
         * <!--                       commands like PUT and DELETE are           -->
         * <!--                       rejected?  [true]                          -->
         *
         * 通过注释可以看到默认情况下当我们进行put或者delete操作的时候，服务器是拒绝访问的，所以想向服务器上传文件必须将readonly属性设置为false。
         * <servlet>
         *     <servlet-name>default</servlet-name>
         *     <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
         *     <!-- 添加，解决jersey上传服务器403错误 -->
         *     <init-param>
         *         <param-name>readonly</param-name>
         *         <param-value>false</param-value>
         *     </init-param>
         *     <init-param>
         *         <param-name>debug</param-name>
         *         <param-value>0</param-value>
         *     </init-param>
         *     <init-param>
         *         <param-name>listings</param-name>
         *         <param-value>false</param-value>
         *     </init-param>
         *     <load-on-startup>1</load-on-startup>
         * </servlet>
         */

        System.out.println(filename);
        return "success";
    }
}

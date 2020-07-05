package web.文件下载;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/image/" + filename);

        //2.2用字节流关联
        FileInputStream inputStream = new FileInputStream(realPath);

        //3.设置response响应头
        String type = context.getMimeType(filename);
        //3.1设置响应头类型
        resp.setHeader("content-type",type);

        //解决中文文件名问题
        /*
            1.获取user-agent请求头
            2.实用工具类方法编码文件名
         */
        String header = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(header, filename);

        //3.设置响应头打开方式
        resp.setHeader("content-disposition","attachment;filename=" + filename);

        //4.将输入流的数据写出到输出流当中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024*8];
        int len = 0;
        while ((inputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }

        inputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

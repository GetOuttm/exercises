package 验证码;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet1")
public class CheckCodeServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //创建一个对象，在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //美化图片
        //填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.pink);//设置画笔颜色
        graphics.fillRect(0,0,width,height);

        //画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);

            //写验证码
            graphics.drawString(c+"",width/5*i,height/2);
        }

        //画干扰线
        graphics.setColor(Color.GREEN);

        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            graphics.drawLine(x1,x2,y1,y2);
        }

        //将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}

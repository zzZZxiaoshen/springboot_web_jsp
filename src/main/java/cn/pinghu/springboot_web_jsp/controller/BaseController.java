package cn.pinghu.springboot_web_jsp.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class BaseController {

    /**
     * 写文件
     */
    protected static void writeFile(HttpServletResponse response, byte[] bytes, String fileName) throws IOException {
        response.setHeader("Content-type", "application/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        write(response, bytes);
    }

    private static void write(HttpServletResponse response, byte[] bytes) throws IOException {
        if (response == null) {
            return;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        OutputStream os = response.getOutputStream();
        os.write(bytes);
        os.flush();
        os.close();
    }


}

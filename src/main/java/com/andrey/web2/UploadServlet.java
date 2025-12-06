package com.andrey.web2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet("/upload-screenshot")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB (буфер в памяти)
        maxFileSize = 1024 * 1024 * 10,  // 10 MB (макс размер файла)
        maxRequestSize = 1024 * 1024 * 15 // 15 MB (макс размер всего запроса)
)
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "server_uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
        System.out.println("1");

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            System.out.println("2");
            Part filePart = req.getPart("screenshot");

            if (filePart == null || filePart.getSize() == 0) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Файл не найден");
                return;
            }

            System.out.println("3");
            String fileName = "screen_" + UUID.randomUUID().toString() + ".png";
            File file = new File(uploadDir, fileName);

            System.out.println("4");
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("5");
            System.out.println("Файл сохранен: " + file.getAbsolutePath());
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("The download is successful");

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Server error: " + e.getMessage());
        }
        System.out.println("6");
    }
}

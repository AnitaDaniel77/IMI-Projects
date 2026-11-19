// Handles picking, saving and confirming a file upload
package com.example.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    private static final String UPLOAD_FOLDER = "uploads/"; // where files get saved

    // Show the upload page
    @GetMapping("/")
    public String index() {
        return "upload"; // templates/upload.html
    }

    // Receive and save the file
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {
            Files.createDirectories(Paths.get(UPLOAD_FOLDER)); // make folder if missing
            byte[] bytes = file.getBytes(); // file content
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename()); // full save path
            Files.write(path, bytes); // save to disk
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Upload failed, please try again");
        }

        return "redirect:/uploadStatus";
    }

    // Show the result message
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus"; // templates/uploadStatus.html
    }
}

/*
src/main/resources/application.properties

spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB

templates/upload.html (key parts)

<form method="POST" enctype="multipart/form-data" action="/upload">
    <input type="file" name="file"/>
    <button type="submit">Upload</button>
</form>
<p th:text="${message}"></p>

templates/uploadStatus.html (key parts)

<p th:text="${message}"></p>
<a href="/">Back to upload</a>
*/
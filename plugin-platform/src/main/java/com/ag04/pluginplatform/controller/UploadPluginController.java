package com.ag04.pluginplatform.controller;

import com.ag04.pluginplatform.Constant;
import com.ag04.pluginplatform.classloader.PluginClassloader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plugins")
public class UploadPluginController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        File targetFile = new File(Constant.PLUGINS_DIR + File.separator + file.getOriginalFilename());
        OutputStream fileOutputStream = new FileOutputStream(targetFile);

        FileCopyUtils.copy(file.getInputStream(), fileOutputStream);

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl.getParent() instanceof PluginClassloader) {
            ((PluginClassloader) cl.getParent()).init();
        }
        return "ok";
    }

    @GetMapping("/list")
    public List<String> listPlugins() {
        return Arrays.stream(Objects.requireNonNull(new File(Constant.PLUGINS_DIR).listFiles())).map(File::getName).toList();
    }

}

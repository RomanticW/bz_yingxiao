package com.baizhi.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dongHua
 * @create 2022/12/29 15:42
 * FileName: FileVo
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public FileVo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileVo setName(String name) {
        this.name = name;
        return this;
    }
}

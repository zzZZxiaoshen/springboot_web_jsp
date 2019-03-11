package cn.pinghu.springboot_web_jsp.entity;

import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 *  权限实体类
 * @author shenkai
 * @date 2018/12/26
 */
public class AuthorityEntity implements Serializable {

    private static final long serialVersionUID = -5407671243988180287L;

    private String article;
    private String url;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package cn.pinghu.springboot_web_jsp.domain;

/**
 *  权限实体类
 * @author shenkai
 * @date 2018/12/26
 */
public class AuthorityDo {

    private Integer id;
    private String article;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

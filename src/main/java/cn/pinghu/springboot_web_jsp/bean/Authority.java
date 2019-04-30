package cn.pinghu.springboot_web_jsp.bean;

public class Authority {
    /**
	* id
	*/
    private Integer id;

    /**
	* article
	*/
    private String article;

    /**
	* url
	*/
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
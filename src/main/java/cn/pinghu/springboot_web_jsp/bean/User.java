package cn.pinghu.springboot_web_jsp.bean;

public class User {
    /**
	* 主键ID
	*/
    private Integer id;

    /**
	* 姓名
	*/
    private String name;

    /**
	* 年龄
	*/
    private Integer age;

    /**
	* 邮箱
	*/
    private String email;

    /**
	* 版本
	*/
    private Integer version;

    private Integer ageEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getAgeEnum() {
        return ageEnum;
    }

    public void setAgeEnum(Integer ageEnum) {
        this.ageEnum = ageEnum;
    }
}
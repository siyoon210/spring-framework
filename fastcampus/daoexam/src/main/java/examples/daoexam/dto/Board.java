package examples.daoexam.dto;

import java.util.Date;

public class Board {
    private Long id;
    private String title;
    private String name;
    private String content;
    private Date regdate;
    private int readCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", readCount=" + readCount +
                '}';
    }

    //    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
//    title varchar(255) not null,
//    name varchar(255) NOT NULL,
//    content text,
//    regdate datetime,
//    read_count int,

}

package com.example.bean;
import java.time.LocalDateTime;

public class ScholarVO {
    private Long scholarId;     // scholar_id (BIGINT/PK)
    private String title;       // title (VARCHAR(200))
    private String organization; // organization (VARCHAR(200))
    private LocalDateTime deadline; // deadline (DATETIME)
    private String category;    // category (VARCHAR(100))
    private int support_amount; // support_amount (INT)
    private String img; // img (VARCHAR(100))

    public ScholarVO(){}

    public ScholarVO(Long scholarId, String title, String organization, LocalDateTime deadline, String category, int support_amount, String img) {
        this.scholarId = scholarId;
        this.title = title;
        this.organization = organization;
        this.deadline = deadline;
        this.category = category;
        this.support_amount = support_amount;
        this.img = img;
    }

    public Long getScholarId() {
        return scholarId;
    }

    public void setScholarId(Long scholarId) {
        this.scholarId = scholarId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSupport_amount() {
        return support_amount;
    }

    public void setSupport_amount(int support_amount) {
        this.support_amount = support_amount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

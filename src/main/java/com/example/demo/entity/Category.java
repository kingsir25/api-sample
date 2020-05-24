package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

    private long id;
    private String name;

    private Set<Article> articles;



	public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    public long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_ARTICLE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
    )
    public Set<Article> getArticles() {
        return articles;
    }
    // other getters and setters...
    public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

}
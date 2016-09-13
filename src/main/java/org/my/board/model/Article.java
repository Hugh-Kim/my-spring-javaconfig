package org.my.board.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by thkim1 on 2016. 9. 11..
 */
@Entity
@Table(name = "ARTICLE")
@Getter
@Setter
public class Article {
	@Id
	private int seqNo;
	private String title;
	private String author;
	private String content;
	private Date createDate;
}

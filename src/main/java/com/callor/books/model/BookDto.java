package com.callor.books.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
	private String b_code;//	VARCHAR(6)
	private String b_name;//	VARCHAR(125)
	private String b_auther;//	VARCHAR(125)
	private String b_comp;//	VARCHAR(125)
	private String b_year;//	15
	private int b_iprice;//	INT
	private int b_rprice;//	INT
	private String b_stop;//	VARCHAR(1)
}

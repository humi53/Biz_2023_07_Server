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
public class RentDto {
	private long rent_seq;//	BIGINT
	private String rent_date;//	VARCHAR(30)
	private String rent_return_date;//	VARCHAR(10)
	private String rent_bcode;//	VARCHAR(6)
	private String rent_ucode;//	VARCHAR(6)
	private String rent_return_yn;//	VARCHAR(1)
	private int rent_point;//	INT

}

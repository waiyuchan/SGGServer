package com.unconme.sgg.entity;

import com.unconme.sgg.entity.*;
import java.util.List;

import javax.persistence.Id;

import org.springframework.lang.Nullable;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="applicant")
public class Applicant {
	@Id
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String aid;
	
	@Column(name="ug_school",type=MySqlTypeConstant.VARCHAR)
    private String ugSchool;
	
	@Column(name="ug_major",type=MySqlTypeConstant.VARCHAR)
    private String ugMajor;
	
	@Column(name="ug_gpa",type=MySqlTypeConstant.FLOAT)
    private Float ugGpa;
	
	@Column(name="ug_note",type=MySqlTypeConstant.VARCHAR)
    private String ugNote;
	
	private MasterApplicant masterInfo;
	
	private List<GMAT> gmat;
	
	private List<GRE> gre;
	
	private List<LSAT>lsat;
	
	private List<IELTS> ielts;
	
	private List<TOEFL> toefl;
	
	private List<StanCase> stanCase;
	
	public Applicant(String aid, @Nullable String ugS, @Nullable String ugM, @Nullable Float ugG, @Nullable String ugN) {
		this.aid = aid;
		this.ugSchool = ugS;
		this.ugMajor = ugM;
		this.ugGpa = ugG;
		this.ugNote = ugN;
	}

}

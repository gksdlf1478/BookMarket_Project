package test.project.ko.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class MemberDTO {
	
	
	@NotEmpty
	@Email
	private String member_email;
	
	@NotEmpty
	@Pattern(regexp="^[0-9a-zA-Z!@#$%^&]*$")  // "/^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{6,}$/gm")
	private String member_pw;
	
	@NotEmpty
	@Length(min=2, max=5)
	private String member_nickname;
	
	@NotEmpty
	@Length(min=9)
	private String member_phone;
	
	@NotEmpty
	private String member_gender;
	
	@NotEmpty
	private String member_birth;	
	
	
	private int pub_no;
	private int type_no;
	private String member_del;
	private String member_date;
	private int member_point;
	private String member_platform;
	
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public int getPub_no() {
		return pub_no;
	}
	public void setPub_no(int pub_no) {
		this.pub_no = pub_no;
	}
	public int getType_no() {
		return type_no;
	}
	public void setType_no(int type_no) {
		this.type_no = type_no;
	}
	public String getMember_del() {
		return member_del;
	}
	public void setMember_del(String member_del) {
		this.member_del = member_del;
	}
	public String getMember_date() {
		return member_date;
	}
	public void setMember_date(String member_date) {
		this.member_date = member_date;
	}
	public int getMember_point() {
		return member_point;
	}
	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}
	public String getMember_platform() {
		return member_platform;
	}
	public void setMember_platform(String member_platform) {
		this.member_platform = member_platform;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_email=" + member_email + ", member_pw=" + member_pw + ", member_nickname="
				+ member_nickname + ", member_phone=" + member_phone + ", member_gender=" + member_gender
				+ ", member_birth=" + member_birth + ", pub_no=" + pub_no + ", type_no=" + type_no + ", member_del="
				+ member_del + ", member_date=" + member_date + ", member_point=" + member_point + ", member_platform="
				+ member_platform + "]";
	}
	
	
	
	
	
}

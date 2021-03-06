package model;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class User {
	
	private String username;
	private String email;
	private String password;
	private long userId;
	private boolean viewNsfwContent;
	private String profilePic;
	private final String gender;
	private LocalDate dateOfBirth;
	private String description = "My funny collection";
	private boolean admin;
	private boolean isVerified;
	private String verificationKey;
	private TreeSet<Gag> gags;

	private TreeSet<Video> videos;
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	private String sep = File.separator;
	private String defaultBirthday = "1916-01-01";

	private static final int MAX_YEAR_OF_BIRTH = 2003;
	private static final int MIN_YEAR_OF_BIRTH = 1916;
	
	public User(String username, String email, String password){
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setUserId(-1);
		this.gender = "Unspecified";
		this.profilePic = ".."+sep+"WebContent"+sep+"siteImages"+sep+"defaultProfilePic.jpg";
		this.viewNsfwContent = false;
		this.dateOfBirth = LocalDate.parse(defaultBirthday);
		this.admin = false;
		this.gags = new TreeSet<>();
		this.isVerified = false;
		this.verificationKey = " ";
		
		
	}
	
	
	public User(String username, String email, String password, int userId, boolean nsfw, String profilePic,
			String gender, LocalDate dateOfBirth, String description, boolean admin, boolean isVerified, String verificationKey) {

		setUsername(username);
		setEmail(email);
		setPassword(password);
		setUserId(userId);
		setViewNsfwContent(nsfw);
		setProfilePic(profilePic);
		setDateOfBirth(dateOfBirth);
		
		setDescription(description);
		setAdmin(admin);
		
		if(gender != null && !gender.isEmpty()){
			this.gender = gender;
		}
		else{
			this.gender = "Male";
		}
		this.isVerified = isVerified;
		this.verificationKey = verificationKey;
		
		this.gags = new TreeSet<Gag>();
		this.videos = new TreeSet<>();
		
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	
	
	public void setUsername(String username) {
		if(username != null && !username.isEmpty()){
			this.username = username;
		}
	}



	public void addGag(Gag gag){
		
		gags.add(gag);
	}
	

	public void setEmail(String email) {
		if(email != null && !email.isEmpty() && email.matches(EMAIL_PATTERN)){
			this.email = email;
		}
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public void setViewNsfwContent(boolean viewNsfwContent) {
		this.viewNsfwContent = viewNsfwContent;
	}




	public void setProfilePic(String profilePic) {
		if(profilePic != null && !profilePic.isEmpty()){
			this.profilePic = profilePic;
		}
	}




	public void setDateOfBirth(LocalDate dateOfBirth) {
		if(dateOfBirth.getYear() >= MIN_YEAR_OF_BIRTH && dateOfBirth.getYear() <= MAX_YEAR_OF_BIRTH){
			this.dateOfBirth = dateOfBirth;
		}
	}


	
	public void setUserId(long userId) {
		this.userId = userId;
	}






	public void setGags(TreeSet<Gag> gags) {
		this.gags = gags;
	}




	public void setDescription(String description) {
		if(description!= null && !description.isEmpty())
			this.description = description;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public long getUserId() {
		return userId;
	}

	public boolean isViewNsfwContent() {
		return viewNsfwContent;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	

	public String getDescription() {
		return description;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public Set<Gag> getGags() {
		return Collections.unmodifiableSet(gags);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", userId=" + userId
				+ ", viewNsfwContent=" + viewNsfwContent + ", profilePic=" + profilePic + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", description=" + description + ", admin=" + admin + ", isVerified="
				+ isVerified + ", verificationKey=" + verificationKey + ", gags=" + gags + ", videos=" + videos + "]\n";
	}


	public boolean verify(String verificationKey) {
		if (this.verificationKey.compareTo(verificationKey) == 0){
			isVerified = true;
		}
		return isVerified;	
	}





	
	
	
	


}

package celum.exercise.springBoot.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Adnan Adnan
 * Non Owner Entity
 */
@Entity
@Table(name = "students")
public class Students implements Serializable {

	public Students() {

	}

	public Students(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Student")
	private Long idStudent;

	@NotNull
	@Size(max = 100)
	@Column(name = "first_Name")
	private String firstName;

	@NotNull
	@Size(max = 100)
	@Column(name = "last_Name")
	private String lastName;

	@NotNull
	@Size(max = 100)
	@Column(name = "email")
	private String email;

	@Size(max = 100)
	@Column(name = "phone_Number")
	private String phoneNumber;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "students")
	private Set<Courses> courses = new HashSet<>();
	
	/**
	 * This function is responsible of removing the student from the courses
	 * while keeping the course intact
	 *
	 */
	@PreRemove
	public void removeStudentFromCourses() {
	    for (Courses c : courses) {
	        c.getStudents().remove(this);
	    }
	}

	public Long getidStudent() {
		return idStudent;
	}

	public void setidStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Students [getidStudent()=");
		builder.append(getidStudent());
		builder.append(", getFirstName()=");
		builder.append(getFirstName());
		builder.append(", getLastName()=");
		builder.append(getLastName());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getPhoneNumber()=");
		builder.append(getPhoneNumber());
		builder.append(", getCourses()=");
		builder.append(getCourses());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}

}

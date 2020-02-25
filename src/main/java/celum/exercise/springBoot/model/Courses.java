package celum.exercise.springBoot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Adnan Adnan
 * Owner Entity holding reference of the student Entity
 */
@Entity
@Table(name = "courses")
public class Courses implements Serializable {

	public Courses() {

	}
	
	public Courses(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public Courses(String name, Date date, Set<Students> students) {
		this.name = name;
		this.date = date;
		this.students = students;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Course")
	private Long idCourse;

	@NotNull
	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
//	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "students_courses", joinColumns = { @JoinColumn(name = "id_Course") }, inverseJoinColumns = { @JoinColumn(name = "id_Student") })
	private Set<Students> students = new HashSet<>();

	public Long getIdCourse() {
		return idCourse;
	}


	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Set<Students> getStudents() {
		return students;
	}


	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Courses [getIdCourse()=");
		builder.append(getIdCourse());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getDate()=");
		builder.append(getDate());
		builder.append(", getStudents()=");
		builder.append(getStudents());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	
	

}

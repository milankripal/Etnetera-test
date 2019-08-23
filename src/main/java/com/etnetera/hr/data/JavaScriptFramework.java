package com.etnetera.hr.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;  
import java.util.ArrayList;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Entity
public class JavaScriptFramework {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;     
        
        @Column(name = "deprecationDate", columnDefinition="DATETIME")
        private LocalDate deprecationDate;
        
        private int hypeLevel;
        private String version;
        
        public JavaScriptFramework(String name, LocalDate deprecationDate, int hypeLevel, String version) {
            this.name = name;
            this.deprecationDate = deprecationDate;
            this.hypeLevel = hypeLevel;
            this.version = version;                   
        }
        private ArrayList<JavaScriptFramework> javaScriptFrameworks = new ArrayList<>();
        
        public void addJavaScriptFramework(String name, LocalDate deprecationDate, int hypeLevel, String version) {
            javaScriptFrameworks.add(new JavaScriptFramework(name, deprecationDate, hypeLevel, version));
        }
        public ArrayList<JavaScriptFramework> findJavaScriptFramework(String name, String version) {
            ArrayList<JavaScriptFramework> found = new ArrayList<>();
            for(JavaScriptFramework j : javaScriptFrameworks) {
                if (j.getName().equals(name)) && (j.getVersion().equals(version)) {
                found.add(j);
                }
            }
            return found;            
        }   
        public void removeJavaScriptFramework(String name, String version) {
            ArrayList<JavaScriptFramework> find = findJavaScriptFramework(name,version);
            for (JavaScriptFramework> j : find) {
            javaScriptFrameworks.remove(j);
            }
        }
        
        public void modifyJavaScriptFramework(String name, String version, String newName, LocalDate newDeprecationDate, int newHypeLevel, String newVersion ) {
            removeJavaScriptFramework(name,version);
            addJavaScriptFramework(newName, newDeprecationDate, newHypeLevel, newVersion);
        }
        

	public JavaScriptFramework() {
	}

	public JavaScriptFramework(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
        
        public String getVersion() {
                return version;
        }

	public void setName(String name) {
		this.name = name;               
	}
       

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + ", version=" + version + ", deprecationDate=" + deprecationDate + ", hypeLevel=" + hypeLevel + "]";
	}

}

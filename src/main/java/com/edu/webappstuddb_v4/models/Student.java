package com.edu.webappstuddb_v4.models;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String group;
    private String faculty;

    public Student() {
    }

    public Student(Long id, String name, String surname, String email, String group, String faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
        this.faculty = faculty;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGroup() {
        return this.group;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$group = this.getGroup();
        final Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) return false;
        final Object this$faculty = this.getFaculty();
        final Object other$faculty = other.getFaculty();
        if (this$faculty == null ? other$faculty != null : !this$faculty.equals(other$faculty)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $group = this.getGroup();
        result = result * PRIME + ($group == null ? 43 : $group.hashCode());
        final Object $faculty = this.getFaculty();
        result = result * PRIME + ($faculty == null ? 43 : $faculty.hashCode());
        return result;
    }

    public String toString() {
        return "Student(name=" + this.getName() + ", surname=" + this.getSurname() + ", email=" + this.getEmail() + ", group=" + this.getGroup() + ", faculty=" + this.getFaculty() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

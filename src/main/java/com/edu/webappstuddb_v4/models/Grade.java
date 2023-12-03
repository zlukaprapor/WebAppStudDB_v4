package com.edu.webappstuddb_v4.models;

public class Grade {
    private Long id;
    private int studentId;
    private int disciplineId;
    private String subject;
    private int grade;
    private String ects;

    public Grade() {
    }

    public Grade(Long id, int studentId, int disciplineId, String subject, int grade, String ects) {
        this.id = id;
        this.studentId = studentId;
        this.disciplineId = disciplineId;
        this.subject = subject;
        this.grade = grade;
        this.ects = ects;
    }

    public Long getId() {
        return this.id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public int getDisciplineId() {
        return this.disciplineId;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getGrade() {
        return this.grade;
    }

    public String getEcts() {
        return this.ects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Grade)) return false;
        final Grade other = (Grade) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getStudentId() != other.getStudentId()) return false;
        if (this.getDisciplineId() != other.getDisciplineId()) return false;
        final Object this$subject = this.getSubject();
        final Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) return false;
        if (this.getGrade() != other.getGrade()) return false;
        final Object this$ects = this.getEcts();
        final Object other$ects = other.getEcts();
        if (this$ects == null ? other$ects != null : !this$ects.equals(other$ects)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Grade;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (int) (result * PRIME + this.getId());
        result = result * PRIME + this.getStudentId();
        result = result * PRIME + this.getDisciplineId();
        final Object $subject = this.getSubject();
        result = result * PRIME + ($subject == null ? 43 : $subject.hashCode());
        result = result * PRIME + this.getGrade();
        final Object $ects = this.getEcts();
        result = result * PRIME + ($ects == null ? 43 : $ects.hashCode());
        return result;
    }

    public String toString() {
        return "Grade(id=" + this.getId() + ", studentId=" + this.getStudentId() + ", disciplineId=" + this.getDisciplineId() + ", subject=" + this.getSubject() + ", grade=" + this.getGrade() + ", ects=" + this.getEcts() + ")";
    }


}

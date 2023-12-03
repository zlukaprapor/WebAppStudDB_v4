package com.edu.webappstuddb_v4.models;

public class Discipline {
    private Long id;
    private String discipline;
    private int studentId;

    public Discipline() {
    }

    public Discipline(Long id, int studentId, String discipline) {
        this.id = id;
        this.discipline = discipline;
        this.studentId = studentId;
    }

    public Long getId() {
        return this.id;
    }

    public String getDiscipline() {
        return this.discipline;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Discipline)) return false;
        final Discipline other = (Discipline) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$discipline = this.getDiscipline();
        final Object other$discipline = other.getDiscipline();
        if (this$discipline == null ? other$discipline != null : !this$discipline.equals(other$discipline))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Discipline;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $discipline = this.getDiscipline();
        result = result * PRIME + ($discipline == null ? 43 : $discipline.hashCode());
        return result;
    }

    public String toString() {
        return "Discipline(id=" + this.getId() + ", discipline=" + this.getDiscipline() + ")";
    }

}

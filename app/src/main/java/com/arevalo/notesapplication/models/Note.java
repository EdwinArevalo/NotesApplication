package com.arevalo.notesapplication.models;


import com.orm.dsl.Table;

@Table
public class Note {

    private Long id;
    private String title;
    private String description;
    private int estado;
    private Long usuarioId;

    public Note(){

    }

    public Note(String title, String description, Long usuarioId) {
        this.title = title;
        this.description = description;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

package com.example.medial.model.dto.response;

public class JobDto {
    private Long id;
    private String title;
    private String description;
    private JobPositionDto position;
    private CurrencyDto currency;
    private Double salary;
    private String enterprise;
    private String tecnologies;
    private ModalityWorkDto modalityWorkDto;

    //TODO: usar prettier library para transformar fecha en algo legible
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ModalityWorkDto getModalityWorkDto() {
        return modalityWorkDto;
    }

    public void setModalityWorkDto(ModalityWorkDto modalityWorkDto) {
        this.modalityWorkDto = modalityWorkDto;
    }

    public String getTecnologies() {
        return tecnologies;
    }

    public void setTecnologies(String tecnologies) {
        this.tecnologies = tecnologies;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public ModalityWorkDto getModalityJobDto() {
        return modalityJobDto;
    }

    public void setModalityJobDto(ModalityWorkDto modalityJobDto) {
        this.modalityJobDto = modalityJobDto;
    }

    private ModalityWorkDto modalityJobDto;


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public JobPositionDto getPosition() {
        return position;
    }

    public void setPosition(JobPositionDto position) {
        this.position = position;
    }

    public CurrencyDto getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDto currency) {
        this.currency = currency;
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
}

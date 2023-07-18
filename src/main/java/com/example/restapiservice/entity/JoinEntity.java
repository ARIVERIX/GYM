    package com.example.restapiservice.entity;

    import jakarta.persistence.*;
    import com.example.restapiservice.entity.Client;

    @Entity
    public class JoinEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Support support;

        @ManyToOne
        private Client client;

        @ManyToOne
        private Administrator administrator;

        @ManyToOne
        private Trainer trainer;

        private String additionalField1;
        private int additionalField2;

        // Конструкторы

        // Геттеры и сеттеры

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Support getSupport() {
            return support;
        }

        public void setSupport(Support support) {
            this.support = support;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public Administrator getAdministrator() {
            return administrator;
        }

        public void setAdministrator(Administrator administrator) {
            this.administrator = administrator;
        }

        public Trainer getTrainer() {
            return trainer;
        }

        public void setTrainer(Trainer trainer) {
            this.trainer = trainer;
        }

        public String getAdditionalField1() {
            return additionalField1;
        }

        public void setAdditionalField1(String additionalField1) {
            this.additionalField1 = additionalField1;
        }

        public int getAdditionalField2() {
            return additionalField2;
        }

        public void setAdditionalField2(int additionalField2) {
            this.additionalField2 = additionalField2;
        }

        // Другие методы

        public void someCustomMethod() {
            // Логика вашего метода
        }

        // ...
    }
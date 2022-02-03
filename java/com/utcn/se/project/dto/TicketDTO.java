package com.utcn.se.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Ticket")
@Table(name = "ticket")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class TicketDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ticket")
    private int idTicket;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_event")
    private int idEvent;

    @Column(name = "price")
    private double price;

    public TicketDTO() {

    }

    public TicketDTO(int idTicket, int idUser, int idEvent, double price) {
        this.idTicket = idTicket;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.price = price;
    }

    public TicketDTO(int idUser, int idEvent, double price) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.price = price;
    }

    public TicketDTO(TicketBuilder builder) {
        this.idTicket = builder.idTicket;
        this.idUser = builder.idUser;
        this.idEvent = builder.idEvent;
        this.price = builder.price;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDTO)) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return getIdTicket() == ticketDTO.getIdTicket() && getIdUser() == ticketDTO.getIdUser() && getIdEvent() == ticketDTO.getIdEvent() && Double.compare(ticketDTO.getPrice(), getPrice()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTicket(), getIdUser(), getIdEvent(), getPrice());
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "idTicket=" + idTicket +
                ", idUser=" + idUser +
                ", idEvent=" + idEvent +
                ", price=" + price +
                '}';
    }

    public static class TicketBuilder {
        private int idTicket;
        private int idUser;
        private int idEvent;
        private double price;

        public TicketBuilder idTicket(int idTicket) {
            this.idTicket = idTicket;
            return this;
        }

        public TicketBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public TicketBuilder idEvent(int idEvent) {
            this.idEvent = idEvent;
            return this;
        }

        public TicketBuilder price(double price) {
            this.price = price;
            return this;
        }

        public TicketDTO build() {
            return new TicketDTO(this);
        }
    }
}

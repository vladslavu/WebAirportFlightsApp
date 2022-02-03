package com.utcn.se.project.model;

import java.util.Objects;

public class Ticket {
    private int idTicket;
    private int idUser;
    private int idEvent;
    private double price;

    public Ticket() {

    }

    public Ticket(int idTicket, int idUser, int idEvent, double price) {
        this.idTicket = idTicket;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.price = price;
    }

    public Ticket(int idUser, int idEvent, double price) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.price = price;
    }

    public Ticket(TicketBuilder builder) {
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
        if (!(o instanceof Ticket)) return false;
        Ticket Ticket = (Ticket) o;
        return getIdTicket() == Ticket.getIdTicket() && getIdUser() == Ticket.getIdUser() && getIdEvent() == Ticket.getIdEvent() && Double.compare(Ticket.getPrice(), getPrice()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTicket(), getIdUser(), getIdEvent(), getPrice());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", idUser=" + idUser +
                ", idEvent=" + idEvent +
                ", price=" + price +
                '}';
    }

    public static class TicketBuilder
    {
        private int idTicket;
        private int idUser;
        private int idEvent;
        private double price;

        public TicketBuilder idTicket(int idTicket)
        {
            this.idTicket = idTicket;
            return this;
        }

        public TicketBuilder idUser(int idUser)
        {
            this.idUser = idUser;
            return this;
        }

        public TicketBuilder idEvent(int idEvent)
        {
            this.idEvent = idEvent;
            return this;
        }

        public TicketBuilder price(double price)
        {
            this.price = price;
            return this;
        }

        public Ticket build()
        {
            return new Ticket(this);
        }
    }
}

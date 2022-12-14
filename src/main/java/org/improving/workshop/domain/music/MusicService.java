package org.improving.workshop.domain.music;

import org.improving.workshop.domain.music.artist.Artist;
import org.improving.workshop.domain.music.event.Event;
import org.improving.workshop.domain.music.stream.Stream;
import org.improving.workshop.domain.music.ticket.Ticket;
import org.improving.workshop.domain.music.venue.Venue;

import java.util.Optional;

public interface MusicService {
    Artist createArtist();
    Artist createArtist(String artistId);
    long artistCount();
    Optional<Venue> createVenue();
    Optional<Venue> createVenue(String addressId);
    long venueCount();
    Optional<Event> createEvent();
    Optional<Event> createEvent(String artistId, String venueId);
    long eventCount();
    Optional<Ticket> bookTicket();
    Optional<Ticket> bookTicket(String eventId, String customerId);
    long ticketCount();
    Optional<Stream> streamArtist();
    Optional<Stream> streamArtist(String artistId, String customerId);
    long streamCount();
}

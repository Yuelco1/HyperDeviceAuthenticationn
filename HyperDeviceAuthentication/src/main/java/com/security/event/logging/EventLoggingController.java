package com.security.event.logging;

import com.github.dockerjava.api.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventLoggingController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public Event logEvent(@RequestBody Event event) {
        // Save event to database
        eventRepository.save(event);

        return event;
    }
}

package com.tripleclub.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tripleclub.dto.EventDto;
import com.tripleclub.entity.User;
import com.tripleclub.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    public static final String ADD = "ADD";
    public static final String MOD = "MOD";
    public static final String DELETE = "DELETE";
    public static final String REVIEW = "REVIEW";
    private final EventService eventService;

    @PostMapping
    public ResponseEntity eventHandler(@RequestBody EventDto eventDto) throws JsonProcessingException {
        User user = new User();
        if(REVIEW.equals(eventDto.getType())){
            if(ADD.equals(eventDto.getAction())){
                user = eventService.addEvent(eventDto);
            }else if(MOD.equals(eventDto.getAction())){
                user = eventService.modEvent(eventDto);
            }else if(DELETE.equals(eventDto.getAction())){
                user = eventService.deleteEvent(eventDto);
            }
        }
        return new ResponseEntity<>(eventService.setResponseEntity(user), HttpStatus.OK);
    }

}

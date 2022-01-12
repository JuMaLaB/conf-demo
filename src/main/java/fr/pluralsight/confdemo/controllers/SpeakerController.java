package fr.pluralsight.confdemo.controllers;

import java.util.List;
// import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.pluralsight.confdemo.models.Speaker;
import fr.pluralsight.confdemo.repositories.SpeakerRepository;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> list() {
    return speakerRepository.findAll();
  }

  @GetMapping
  @RequestMapping("{id}")
  public Speaker get(@PathVariable Long id) {
    return speakerRepository.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker create(@RequestBody final Speaker Speaker) {
    return speakerRepository.saveAndFlush(Speaker);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    // check for children records before deleting.
    speakerRepository.deleteById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
    // TODO : validation that all attributes are passed in, otherwise 400
    Speaker existingSpeaker = speakerRepository.getById(id);
    BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
    return speakerRepository.saveAndFlush(existingSpeaker);
  }
}

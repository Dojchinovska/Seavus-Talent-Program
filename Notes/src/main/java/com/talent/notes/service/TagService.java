package com.talent.notes.service;

import com.talent.notes.model.Tag;
import com.talent.notes.model.User;
import com.talent.notes.repository.TagRepository;
import com.talent.notes.repository.UserRepository;
import com.talent.notes.security.SecurityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;

    private UserRepository userRepository;

    private SecurityService securityService;

    public TagService(TagRepository tagRepository, UserRepository userRepository, SecurityService securityService) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    public Optional<Tag> findTag(Long id) {

        return tagRepository.findById(id);
    }

    public List<Tag> findTags(User user) {

        return tagRepository.findByUser(user);
    }

    public void deleteTagById(Long id) {

        tagRepository.deleteById(id);
    }

    public Tag createTag(String name) {

        User user = securityService.getAuthenticatedUser();
        Tag tag = new Tag(name, user);
        return tagRepository.save(tag);
    }
}
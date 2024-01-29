package pl.javastart.bootcamp.domain.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.javastart.bootcamp.mail.MailService;

import javax.validation.Valid;

@RequestMapping("/kontakt")
@Controller
public class ContactController {
    private final MailService mailService;

    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping
    public String contactForm(Model model) {
        model.addAttribute("contact", new ContactDto());
        return "contact";
    }

    @PostMapping("/skontaktuj-sie")
    public String makeContact(@Valid @ModelAttribute("contact") ContactDto contactDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contact", contactDto);
            return "contact";
        } else {
            mailService.sendNewContactFormMessage(contactDto);
            mailService.sendContactFormConfirmationMessage(contactDto);
            return "redirect:/";
        }
    }
}

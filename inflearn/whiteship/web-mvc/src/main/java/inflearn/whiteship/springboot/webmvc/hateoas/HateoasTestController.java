package inflearn.whiteship.springboot.webmvc.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class HateoasTestController {
    @GetMapping("/hello-hateoas")
    public @ResponseBody
    Resource<Hello> hello() {
        Hello hello = new Hello();
        hello.setId(1);
        hello.setName("siyoon");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(HateoasTestController.class).hello()).withSelfRel());

        return helloResource;
    }

    static class Hello {
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }
    }
}

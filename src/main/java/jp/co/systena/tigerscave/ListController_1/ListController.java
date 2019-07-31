package jp.co.systena.tigerscave.ListController_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {
@RequestMapping("/show")
//@GetMapping("/show")
public ModelAndView show(ModelAndView mav) {
  mav.addObject("Item", new Item());
  //model.addAttribute("Item", new Item());
  mav.setViewName("show");
  return mav;
}

//@RequestMapping(path = "/order", method = RequestMethod.POST)
//public String submit(@ModelAttribute("param1") String param1, @ModelAttribute("param2") String param2) {

//    return "order";
//}

//@RequestMapping(path = "/order", method = RequestMethod.GET)
//@GetMapping
//@PostMapping
//public ModelAndView init(ModelAndView mav2) {
//  mav2.addObject("ListForm",new ListForm());
//  mav2.setViewName("order");
//  return mav2;
//}

//@RequestMapping(path = "/order", method = RequestMethod.POST)
//@PostMapping
//@GetMapping
//public String submit(ListForm form) {
//  System.out.println("form.value=" + form.getNum1());
//  return "order";
//}

//  入力画面
@GetMapping("/input")
public String input(@ModelAttribute("listform") ListForm listform) {
    return "input";
}

//  書籍情報画面
@PostMapping("/output")
public String toBookInfo(@ModelAttribute("listform") ListForm listform) {
    return "output";
}


public static class Item {

  public int itemId1 = 1;
  public String name1 = "name1";
  public int price1 = 1000;

  public int itemId2 = 2;
  public String name2 = "name2";
  public int price2 = 2000;



}


}

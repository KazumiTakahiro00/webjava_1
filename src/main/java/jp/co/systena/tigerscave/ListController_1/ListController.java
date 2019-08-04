package jp.co.systena.tigerscave.ListController_1;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ListController {

@Autowired
HttpSession session;

//  商品一覧画面表示
@RequestMapping("/show")
public ModelAndView show(ModelAndView mav) {
  mav.addObject("Item", new Item());
  mav.setViewName("show");
  return mav;
}

//  注文入力画面表示(カート追加)
@GetMapping("/order")
public String input(@ModelAttribute("listform") ListForm listform) {

  //値が設定されているかコンソールに表示してみる(debug)
  //System.out.println("a");
  //System.out.printf("%d\n",listform.getNum1());

  return "order";
}

//  注文合計画面表示(カート表示)
@GetMapping("/output")
public String output(@ModelAttribute("listform") ListForm listform) {

  int session_num1;
  int session_num2;

  //値が設定されているかコンソールに表示してみる(debug)
  //System.out.println("b");
  //System.out.printf("%d\n",listform.getNum1());
  //System.out.println((String)session.getAttribute("num1"));

  //セッションに保存している注文済数量を取り出して新たに注文された数量をプラスしてセッションに保存。
  if(((String)session.getAttribute("num1")) == null) {
    session_num1 = 0;
  }else {
    session_num1 = Integer.parseInt((String)session.getAttribute("num1"));
  }
  session.setAttribute("num1", Integer.toString(session_num1 + listform.getNum1()));

  //値が設定されているかコンソールに表示してみる(debug)
  //System.out.println("c");
  //System.out.println((String)session.getAttribute("num1"));
  //System.out.printf("%d\n",Integer.parseInt((String)session.getAttribute("num1")));

  //注文合計数をlistformに更新
  listform.setNum1(Integer.parseInt((String)session.getAttribute("num1")));

  //注文合計金額をlistformに更新
  listform.setNum1_sum(new Item().price1);

  //以下商品Item2でも同様に実施
  if(((String)session.getAttribute("num2")) == null) {
    session_num2 = 0;
  }else {
    session_num2 = Integer.parseInt((String)session.getAttribute("num2"));
  }
  session.setAttribute("num2", Integer.toString(session_num2 + listform.getNum2()));

  //注文合計数をlistformに更新
  listform.setNum2(Integer.parseInt((String)session.getAttribute("num2")));

  //注文合計金額をlistformに更新
  listform.setNum2_sum(new Item().price2);

  return "output";
}

//商品一覧は固定で設定
public static class Item {

  public int itemId1 = 1;
  public String name1 = "商品1";
  public int price1 = 1000;

  public int itemId2 = 2;
  public String name2 = "商品2";
  public int price2 = 2000;

}

}

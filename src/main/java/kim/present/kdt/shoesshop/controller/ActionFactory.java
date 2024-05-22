package kim.present.kdt.shoesshop.controller;

import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.controller.action.IndexAction;
import kim.present.kdt.shoesshop.controller.action.member.*;
import kim.present.kdt.shoesshop.controller.action.mypage.*;
import kim.present.kdt.shoesshop.controller.action.product.CategoryAction;
import kim.present.kdt.shoesshop.controller.action.product.ProductDetailAction;

public class ActionFactory {

    private ActionFactory() {
    }

    private static final ActionFactory instance = new ActionFactory();

    public static ActionFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {
        Action ac = null;

        switch (command) {
            case "index":
                ac = new IndexAction();
                break;

            //member
            case "loginForm":
                ac = new LoginFormAction();
                break;
            case "login":
                ac = new LoginAction();
                break;
            case "logout":
                ac = new LogoutAction();
                break;
            case "contract":
                ac = new ContractAction();
                break;
            case "joinForm":
                ac = new JoinFormAction();
                break;
            case "idcheckForm":
                ac = new IdcheckFormAction();
                break;
            case "findZipnum":
                ac = new FindZipnumAction();
                break;
            case "join":
                ac = new JoinAction();
                break;

            //product
            case "category":
                ac = new CategoryAction();
                break;
            case "productDetail":
                ac = new ProductDetailAction();
                break;

            // mypage
            case "cartInsert":
                ac = new CartInsertAction();
                break;
            case "cartList":
                ac = new CartListAction();
                break;
            case "cartDelete":
                ac = new CartDeleteAction();
                break;
            case "orderInsert":
                ac = new OrderInsertAction();
                break;
            case "orderList":
                ac = new OrderListAction();
                break;
            case "orderInsertOne":
                ac = new OrderInsertOneAction();
                break;
        }

        return ac;
    }

}







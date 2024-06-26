package kim.present.kdt.shoesshop.controller;

import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.controller.action.IndexAction;
import kim.present.kdt.shoesshop.controller.action.admin.*;
import kim.present.kdt.shoesshop.controller.action.customer.QnaListAction;
import kim.present.kdt.shoesshop.controller.action.customer.QnaViewAction;
import kim.present.kdt.shoesshop.controller.action.customer.WriteQnaAction;
import kim.present.kdt.shoesshop.controller.action.customer.WriteQnaFormAction;
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

            case "mypage":
                ac = new MypageAction();
                break;
            case "orderAll":
                ac = new OrderAllAction();
                break;
            case "updateMemberForm":
                ac = new UpdateMemberFormAction();
                break;
            case "updateMember":
                ac = new UpdateMemberAction();
                break;
            case "deleteMember":
                ac = new DeleteMemberAction();
                break;
            case "orderDetail":
                ac = new OrderDetailAction();
                break;

            // customer
            case "qnaList":
                ac = new QnaListAction();
                break;
            case "qnaView":
                ac = new QnaViewAction();
                break;
            case "writeQnaForm":
                ac = new WriteQnaFormAction();
                break;
            case "writeQna":
                ac = new WriteQnaAction();
                break;

            // admin
            case "admin":
                ac = new AdminAction();
                break;
            case "adminLogin":
                ac = new AdminLoginAction();
                break;
            case "adminLogout":
                ac = new AdminLogoutAction();
                break;
            case "adminProductList":
                ac = new AdminProductListAction();
                break;
            case "adminProductWriteForm":
                ac = new AdminProductWriteFormAction();
                break;
            case "adminProductWrite":
                ac = new AdminProductWriteAction();
                break;
            case "adminProductDetail":
                ac = new AdminProductDetailAction();
                break;
            case "adminProductUpdateForm":
                ac = new AdminProductUpdateFormAction();
                break;
            case "adminProductUpdate":
                ac = new AdminProductUpdateAction();
                break;
            case "adminProductDelete":
                ac = new AdminProductDeleteAction();
                break;

            case "adminOrderList":
                ac = new AdminOrderListAction();
                break;
            case "adminOrderSave":
                ac = new AdminOrderSaveAction();
                break;
            case "adminMemberList":
                ac = new AdminMemberListAction();
                break;
            case "memberChangeN":
                ac = new MemberChangeNAction();
                break;
            case "memberChangeY":
                ac = new MemberChangeYAction();
                break;

            case "adminQnaList":
                ac = new AdminQnaListAction();
                break;
            case "adminQnaDetail":
                ac = new AdminQnaDetailAction();
                break;
            case "adminQnaRepSave":
                ac = new AdminQnaRepSaveAction();
                break;
        }

        return ac;
    }

}







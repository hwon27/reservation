package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	
	static final String CATEGORYS = "Select category.id , category.name, count(*) as count  from product inner join category inner join display_info ON product.id = display_info.product_id AND product.category_id = category.id GROUP BY product.category_id";
	
	static final String ALL_COUNT = "SELECT count(*) FROM product inner join display_info ON product.id = display_info.product_id";
	
	static final String CATE_COUNT = "SELECT count(*) FROM product inner join display_info ON product.id = display_info.product_id WHERE category_id = :categoryId";
	
	static final String ALL_PRODUCT= "SELECT di.id displayInfoId, di.place_name, p.content productContent, p.description productDescription, p.id productId, fi.save_file_name productImageUrl FROM product p inner join display_info di inner join file_info fi inner join product_image pi ON p.id = di.product_id AND pi.product_id = p.id AND pi.file_id = fi.id WHERE pi.type = 'th' limit :start, :limit";
			
	static final String CATE_PRODUCT="SELECT di.id displayInfoId, di.place_name, p.content productContent, p.description productDescription, p.id productId, fi.save_file_name productImageUrl FROM product p inner join display_info di inner join file_info fi inner join product_image pi ON p.id = di.product_id AND pi.product_id = p.id AND pi.file_id = fi.id WHERE pi.type = 'th' AND p.category_id = :categoryId limit :start, :limit";
	
	static final String PROMOTION = "SELECT pm.id, p.id productId, fi.save_file_name productImageUrl FROM product p inner join display_info di inner join file_info fi inner join product_image pi inner join promotion pm ON p.id = di.product_id AND pi.product_id = p.id AND pi.file_id = fi.id AND pm.product_id = p.id WHERE pi.type = 'th'";
	
	
	
	static final String COMMENT_IMAGES = "SELECT fi.content_type as contentType, fi.create_date as createDate, fi.delete_flag as deleteFlag, fi.id as fileId, fi.file_name as fileName, fi.modify_date as modifyDate, fi.save_file_name as saveFileName, ruci.id as imageId, ri.id as reservationInfoId, ruc.id as reservationUserCommentId FROM file_info fi inner join reservation_user_comment_image ruci inner join reservation_info ri inner join reservation_user_comment ruc ON ri.id = ruci.reservation_info_id AND ruc.id = ruci.reservation_user_comment_id AND ruci.file_id = fi.id";
	
	static final String COMMENTS = "SELECT ruc.comment, ruc.id as commentId, ruc.create_date as createDate, ruc.modify_date as modifyDate, p.id as productId, ri.reservation_date as reservationDate, ri.reservation_email as reservationEmail, ri.id as reservationInfoId, ri.reservation_name as reservationName, ri.reservation_tel as reservationTelephone, ruc.score FROM reservation_user_comment ruc INNER JOIN product p INNER JOIN reservation_info ri INNER JOIN display_info di ON p.id = ruc.product_id AND ri.id = ruc.reservation_info_id AND di.product_id = p.id where di.id = :displayInfoId order by commentId desc";
	
	static final String DISPLAY_INFO = "SELECT c.id as categoryId, c.name as categoryName, di.create_date as createDate, di.id as displayInfoId, di.email, di.homepage, di.modify_date as modifyDate, di.opening_hours as openingHours, di.place_lot as placeLot, di.place_name as placeName, di.place_street as placeStreet, p.content as productContent, p.description as productDescription, p.event as productEvent, p.id as productId, di.tel as telephone FROM category c INNER JOIN display_info di INNER JOIN product p ON p.id = di.product_id AND p.category_id = c.id WHERE di.id = :displayInfoId" ;
	
	static final String DISPLAY_INFO_IMAGE = "SELECT fi.content_type as contentType, fi.create_date as createDate, fi.delete_flag as deleteFlag, fi.id as fileId, fi.file_name as fileName, fi.modify_date as modifyDate, fi.save_file_name as saveFileName, di.id as displayInfoId, dii.id as displayInfoImageId FROM file_info fi INNER JOIN display_info di INNER JOIN display_info_image dii ON di.id = dii.display_info_id AND dii.file_id = fi.id WHERE di.id = :displayInfoId ";
	
	static final String PRODUCT_IMAGES = "SELECT fi.content_type as contentType, fi.create_date as createDate, fi.delete_flag as deleteFlag, fi.id as fileInfoId, fi.file_name as fileName, fi.modify_date as modifyDate, fi.save_file_name as saveFileName, p.id as productId, pi.id as productImageId, pi.type FROM file_info fi INNER JOIN product p INNER JOIN product_image pi INNER JOIN display_info di ON p.id = pi.product_id AND fi.id = pi.file_id AND di.product_id = p.id WHERE (pi.type = 'ma' OR pi.type = 'et') AND di.id = :displayInfoId";
	
	static final String PRODUCT_PRICES = "SELECT pp.create_date as createDate, pp.discount_rate as discountRate, pp.modify_date as modifyDate, pp.price, pp.price_type_name as priceTypeName, pp.product_id as productId, pp.id as productPriceId FROM product_price pp INNER JOIN product p INNER JOIN display_info di ON pp.product_id = p.id AND di.product_id = p.id where di.id = :displayInfoId order by pp.id desc";
	
	static final String GET_PRODUCT_PRICE = "SELECT id as product_price_id, product_id, price_type_name, price, discount_rate, create_date, modify_date FROM product_price WHERE id = :productPriceId";
	 
	static final String GET_IMAGE_BY_FILE_ID = "select * from file_info where id = :fileId";
	
	static final String GET_FILE_ID_BY_PRODUCT_ID = "select file_id from product_image where type = 'th' and product_id = :productId";
	
	static final String GET_FILE_ID_BY_DISPLAY_INFO_ID = "SELECT fi.id as fileId FROM file_info fi INNER JOIN display_info di INNER JOIN display_info_image dii ON di.id = dii.display_info_id AND dii.file_id = fi.id WHERE di.id = :displayInfoId";
	 
	
	
		
	static final String SELECT_RESERVATION_INFO_BY_RESERVATION_EMAIL = "SELECT  id reservationInfoId, product_id productId, display_info_id displayInfoId, reservation_name reservationName, reservation_tel reservationTelephone, reservation_email reservationEmail, cancel_flag cancelYn, reservation_date reservationDate, create_date createDate, modify_date modifyDate FROM reservation_info WHERE reservation_email = :reservationEmail";
	
	static final String SELECT_RESERVATION_INFO_BY_RESERVATION_INFO_ID = "SELECT id reservationInfoId, product_id productId, display_info_id displayInfoId, reservation_name reservationName, reservation_tel reservationTelephone, reservation_email reservationEmail, cancel_flag cancelYn, reservation_date reservationDate, create_date createDate, modify_date modifyDate FROM reservation_info WHERE id = :reservationInfoId ";
	
	static final String GET_RESERVATION_PRICE = "SELECT id as reservation_info_price_id, reservation_info_id, product_price_id, count FROM reservation_info_price WHERE reservation_info_id = :reservationInfoId ";
	 
	static final String UPDATE_RESERVATION_INFO_CANCEL_FLAG = "UPDATE reservation_info SET cancel_flag = 1, modify_date = now() WHERE id = :reservationInfoId";
	 
	
	
	
	static final String COMMENTS_BY_ID = "SELECT id as commentId, product_id as productId, reservation_info_id as reservationInfoId, score, comment, create_date as createDate, modify_date as modifyDate FROM reservation_user_comment WHERE id = :commentId"; 
	 
	static final String COMMENT_IMAGE_BY_COMMENTID = "SELECT ruci.id as imageId, ruci.reservation_info_id as reservationInfoId, ruci.reservation_user_comment_id as reservationUserCommentId, ruci.file_id as fileId, fi.file_name as fileName, fi.save_file_name as saveFileName, fi.content_type as contentType, fi.delete_flag as deleteFlag, fi.create_date as createDate, fi.modify_date as modifyDate FROM reservation_user_comment_image ruci INNER JOIN file_info fi ON ruci.file_id = fi.id WHERE reservation_user_comment_id = :commentId ";
	
	static final String GET_COMMENT_ID_BY_IMAGE_ID = "select reservation_user_comment_id from reservation_user_comment_image where id = :imageId";
	
	}



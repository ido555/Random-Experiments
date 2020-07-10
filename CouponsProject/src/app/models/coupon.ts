import { CouponCategory } from './../enums/coupon-category.enum';
export class Coupon {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )

    private id : Number;
    private amount : Number;
    private price : Number;
    private title : String;
    private description : String;
    private image : String;
    private startDate : Date;
    private endDate : Date;
    private couponCategory : CouponCategory;

	constructor($id: Number, $amount: Number, $price: Number, $title: String, $description: String, $image: String, $startDate: Date, $endDate: Date, $couponCategory: CouponCategory) {
		this.id = $id;
		this.amount = $amount;
		this.price = $price;
		this.title = $title;
		this.description = $description;
		this.image = $image;
		this.startDate = $startDate;
		this.endDate = $endDate;
		this.couponCategory = $couponCategory;
	}

    /**
     * Getter $id
     * @return {Number}
     */
	public get $id(): Number {
		return this.id;
	}

    /**
     * Getter $amount
     * @return {Number}
     */
	public get $amount(): Number {
		return this.amount;
	}

    /**
     * Getter $price
     * @return {Number}
     */
	public get $price(): Number {
		return this.price;
	}

    /**
     * Getter $title
     * @return {String}
     */
	public get $title(): String {
		return this.title;
	}

    /**
     * Getter $description
     * @return {String}
     */
	public get $description(): String {
		return this.description;
	}

    /**
     * Getter $image
     * @return {String}
     */
	public get $image(): String {
		return this.image;
	}

    /**
     * Getter $startDate
     * @return {Date}
     */
	public get $startDate(): Date {
		return this.startDate;
	}

    /**
     * Getter $endDate
     * @return {Date}
     */
	public get $endDate(): Date {
		return this.endDate;
	}

    /**
     * Getter $couponCategory
     * @return {CouponCategory}
     */
	public get $couponCategory(): CouponCategory {
		return this.couponCategory;
	}

    /**
     * Setter $id
     * @param {Number} value
     */
	public set $id(value: Number) {
		this.id = value;
	}

    /**
     * Setter $amount
     * @param {Number} value
     */
	public set $amount(value: Number) {
		this.amount = value;
	}

    /**
     * Setter $price
     * @param {Number} value
     */
	public set $price(value: Number) {
		this.price = value;
	}

    /**
     * Setter $title
     * @param {String} value
     */
	public set $title(value: String) {
		this.title = value;
	}

    /**
     * Setter $description
     * @param {String} value
     */
	public set $description(value: String) {
		this.description = value;
	}

    /**
     * Setter $image
     * @param {String} value
     */
	public set $image(value: String) {
		this.image = value;
	}

    /**
     * Setter $startDate
     * @param {Date} value
     */
	public set $startDate(value: Date) {
		this.startDate = value;
	}

    /**
     * Setter $endDate
     * @param {Date} value
     */
	public set $endDate(value: Date) {
		this.endDate = value;
	}

    /**
     * Setter $couponCategory
     * @param {CouponCategory} value
     */
	public set $couponCategory(value: CouponCategory) {
		this.couponCategory = value;
	}

}

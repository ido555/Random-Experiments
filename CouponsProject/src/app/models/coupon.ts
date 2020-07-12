import { CouponCategory } from './../enums/coupon-category.enum';
export class Coupon {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )

    private couponId : number;
    private amount : number;
    private price : number;
    private title : string;
    private description : string;
    private image : string;
    private startDate : Date;
    private endDate : Date;
    private couponCategory : CouponCategory;

	constructor($couponId: number, $amount: number, $price: number, $title: string, $description: string, $image: string, $startDate: Date, $endDate: Date, $couponCategory: CouponCategory) {
		this.couponId = $couponId;
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
     * Getter $couponId
     * @return {number}
     */
	public get $couponId(): number {
		return this.couponId;
	}

    /**
     * Getter $amount
     * @return {number}
     */
	public get $amount(): number {
		return this.amount;
	}

    /**
     * Getter $price
     * @return {number}
     */
	public get $price(): number {
		return this.price;
	}

    /**
     * Getter $title
     * @return {string}
     */
	public get $title(): string {
		return this.title;
	}

    /**
     * Getter $description
     * @return {string}
     */
	public get $description(): string {
		return this.description;
	}

    /**
     * Getter $image
     * @return {string}
     */
	public get $image(): string {
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
     * Setter $couponId
     * @param {number} value
     */
	public set $couponId(value: number) {
		this.couponId = value;
	}

    /**
     * Setter $amount
     * @param {number} value
     */
	public set $amount(value: number) {
		this.amount = value;
	}

    /**
     * Setter $price
     * @param {number} value
     */
	public set $price(value: number) {
		this.price = value;
	}

    /**
     * Setter $title
     * @param {string} value
     */
	public set $title(value: string) {
		this.title = value;
	}

    /**
     * Setter $description
     * @param {string} value
     */
	public set $description(value: string) {
		this.description = value;
	}

    /**
     * Setter $image
     * @param {string} value
     */
	public set $image(value: string) {
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

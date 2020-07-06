import { CouponCategory } from './../enums/coupon-category.enum';
export class Coupon {
    constructor(
        id, amount, price: Number,
        title, description, image: String,
        startDate, endDate: Date,
        couponCategory: CouponCategory
    ){}
}

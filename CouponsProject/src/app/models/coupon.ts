import { CouponCategory } from './../enums/coupon-category.enum';
import { title } from 'process';

export class Coupon {
    constructor(
        id, amount, price: Number,
        title, description, image: String,
        startDate, endDate: Date,
        couponCategory: CouponCategory
    ){}
}

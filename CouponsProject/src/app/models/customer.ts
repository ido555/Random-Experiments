import { Coupon } from './coupon';
export class Customer {
    constructor(
        id: number,
        firstName, lastName, email, password: String,
        coupons:Coupon[]
    ){}

}

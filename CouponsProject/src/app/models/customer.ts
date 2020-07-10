import { Coupon } from './coupon';
export class Customer {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )
    private id: Number;
    private password: String;
    private email: String;
    private firstName: String;
    private lastName: String;
    private coupons: Coupon[];

    constructor($id: Number, $password: String, $email: String, $firstName: String, $lastName: String, $coupons: Coupon[]) {
        this.id = $id;
        this.password = $password;
        this.email = $email;
        this.firstName = $firstName;
        this.lastName = $lastName;
        this.coupons = $coupons;
    }

    /**
     * Getter $id
     * @return {Number}
     */
    public get $id(): Number {
        return this.id;
    }

    /**
     * Getter $password
     * @return {String}
     */
    public get $password(): String {
        return this.password;
    }

    /**
     * Getter $email
     * @return {String}
     */
    public get $email(): String {
        return this.email;
    }

    /**
     * Getter $firstName
     * @return {String}
     */
    public get $firstName(): String {
        return this.firstName;
    }

    /**
     * Getter $lastName
     * @return {String}
     */
    public get $lastName(): String {
        return this.lastName;
    }

    /**
     * Getter $coupons
     * @return {Coupon[]}
     */
    public get $coupons(): Coupon[] {
        return this.coupons;
    }

    /**
     * Setter $id
     * @param {Number} value
     */
    public set $id(value: Number) {
        this.id = value;
    }

    /**
     * Setter $password
     * @param {String} value
     */
    public set $password(value: String) {
        this.password = value;
    }

    /**
     * Setter $email
     * @param {String} value
     */
    public set $email(value: String) {
        this.email = value;
    }

    /**
     * Setter $firstName
     * @param {String} value
     */
    public set $firstName(value: String) {
        this.firstName = value;
    }

    /**
     * Setter $lastName
     * @param {String} value
     */
    public set $lastName(value: String) {
        this.lastName = value;
    }

    /**
     * Setter $coupons
     * @param {Coupon[]} value
     */
    public set $coupons(value: Coupon[]) {
        this.coupons = value;
    }

}

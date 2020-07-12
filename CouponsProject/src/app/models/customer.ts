import { Coupon } from './coupon';
export class Customer {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )
    private customerId: number;
    private password: string;
    private email: string;
    private firstName: string;
    private lastName: string;
    private coupons: Coupon[];

    constructor($customerId: number, $password: string, $email: string, $firstName: string, $lastName: string, $coupons: Coupon[]) {
        this.customerId = $customerId;
        this.password = $password;
        this.email = $email;
        this.firstName = $firstName;
        this.lastName = $lastName;
        this.coupons = $coupons;
    }

    /**
     * Getter $customerId
     * @return {number}
     */
    public get $customerId(): number {
        return this.customerId;
    }

    /**
     * Getter $password
     * @return {string}
     */
    public get $password(): string {
        return this.password;
    }

    /**
     * Getter $email
     * @return {string}
     */
    public get $email(): string {
        return this.email;
    }

    /**
     * Getter $firstName
     * @return {string}
     */
    public get $firstName(): string {
        return this.firstName;
    }

    /**
     * Getter $lastName
     * @return {string}
     */
    public get $lastName(): string {
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
     * Setter $customerId
     * @param {number} value
     */
    public set $customerId(value: number) {
        this.customerId = value;
    }

    /**
     * Setter $password
     * @param {string} value
     */
    public set $password(value: string) {
        this.password = value;
    }

    /**
     * Setter $email
     * @param {string} value
     */
    public set $email(value: string) {
        this.email = value;
    }

    /**
     * Setter $firstName
     * @param {string} value
     */
    public set $firstName(value: string) {
        this.firstName = value;
    }

    /**
     * Setter $lastName
     * @param {string} value
     */
    public set $lastName(value: string) {
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

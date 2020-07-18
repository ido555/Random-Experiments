/* tslint:disable:no-redundant-jsdoc */
import {CouponCategory} from '../enums/coupon-category.enum';

export class Coupon {
  private couponId: number;
  private amount: number;
  private price: number;
  private title: string;
  private description: string;
  private image: string;
  private startDate: Date;
  private endDate: Date;
  private category: CouponCategory;

  constructor($couponId: number, $amount: number, $price: number, $title: string, $description: string, $image: string
    , $startDate: Date, $endDate: Date, category: CouponCategory) {
    this.couponId = $couponId;
    this.amount = $amount;
    this.price = $price;
    this.title = $title;
    this.description = $description;
    this.image = $image;
    this.startDate = $startDate;
    this.endDate = $endDate;
    this.category = category;
  }

  /**
   * Getter $couponId
   * @return {number}
   */
  public get $couponId(): number {
    return this.couponId;
  }

  /**
   * Setter $couponId
   * @param {number} value
   */
  public set $couponId(value: number) {
    this.couponId = value;
  }

  /**
   * Getter $amount
   * @return {number}
   */
  public get $amount(): number {
    return this.amount;
  }

  /**
   * Setter $amount
   * @param {number} value
   */
  public set $amount(value: number) {
    this.amount = value;
  }

  /**
   * Getter $price
   * @return {number}
   */
  public get $price(): number {
    return this.price;
  }

  /**
   * Setter $price
   * @param {number} value
   */
  public set $price(value: number) {
    this.price = value;
  }

  /**
   * Getter $title
   * @return {string}
   */
  public get $title(): string {
    return this.title;
  }

  /**
   * Setter $title
   * @param {string} value
   */
  public set $title(value: string) {
    this.title = value;
  }

  /**
   * Getter $description
   * @return {string}
   */
  public get $description(): string {
    return this.description;
  }

  /**
   * Setter $description
   * @param {string} value
   */
  public set $description(value: string) {
    this.description = value;
  }

  /**
   * Getter $image
   * @return {string}
   */
  public get $image(): string {
    return this.image;
  }

  /**
   * Setter $image
   * @param {string} value
   */
  public set $image(value: string) {
    this.image = value;
  }

  /**
   * Getter $startDate
   * @return {Date}
   */
  public get $startDate(): Date {
    return this.startDate;
  }

  /**
   * Setter $startDate
   * @param {Date} value
   */
  public set $startDate(value: Date) {
    this.startDate = value;
  }

  /**
   * Getter $endDate
   * @return {Date}
   */
  public get $endDate(): Date {
    return this.endDate;
  }

  /**
   * Setter $endDate
   * @param {Date} value
   */
  public set $endDate(value: Date) {
    this.endDate = value;
  }

  /**
   * Getter $couponCategory
   * @return {CouponCategory}
   */
  public get $category(): CouponCategory {
    return this.category;
  }

  /**
   * Setter $couponCategory
   * @param {CouponCategory} value
   */
  public set $category(value: CouponCategory) {
    this.category = value;
  }

}

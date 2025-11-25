# 🏢 DormMATE - Dormitory Management, Allocation, Tracking, and Engagement System

## 📋 Project Description

**DormMATE** is a Java-based dormitory listing and management system that helps **landlords** post available dorms and **students** browse and book accommodations. Think of it like a simplified Facebook Marketplace for dorms - landlords create listings, students search and inquire, avoiding scams through a centralized platform.

### 🎯 Core Features:
1. **Landlords** can post dorm listings with details (location, price, amenities)
2. **Students** can browse available dorms and filter by location/budget
3. **Students** can inquire/book rooms
4. **Real-time tracking** of room availability
5. Prevents scams by centralizing all interactions

---

## 🏛️ Four Pillars of OOP (Simplified for Java Console/GUI)

| Pillar | Implementation |
|--------|----------------|
| **Encapsulation** | All classes use private fields with getters/setters |
| **Inheritance** | `Student` and `Landlord` both extend `Person` |
| **Polymorphism** | `displayInfo()` overridden in Student and Landlord |
| **Abstraction** | `Person` is abstract; hides complex implementation details |

Concept	displayInfo()
Abstraction	✅ Abstract method in Person (walang body)
Polymorphism	✅ Different implementations in Student & Landlord
---

## 📊 CLASS DIAGRAM (UPDATED)

```
+--------------------------------------------+
|           Person (ABSTRACT) 👤             |  ◄─── ABSTRACTION
+--------------------------------------------+
| - name: String                             |
| - email: String                            |
| - contactInfo: String                      |
| - address: String                          |
+--------------------------------------------+
| + Person(name, email, contactInfo, address)|
| + getName(): String                        |
| + setName(String): void                    |
| + getEmail(): String                       |
| + setEmail(String): void                   |
| + getContactInfo(): String                 |
| + setContactInfo(String): void             |
| + getAddress(): String                     |
| + setAddress(String): void                 |
| + displayInfo(): String (ABSTRACT)         |  ◄─── POLYMORPHISM
+--------------------------------------------+
              ▲                   ▲
              |                   |
      ┌───────┴────────┐  ┌──────┴────────┐
      |                |  |               |
+------------------+   +-------------------+
|    Student 🎓    |   |   Landlord 🏠     |
+------------------+   +-------------------+
| INHERITANCE ◄────────┴─── INHERITANCE    |
+------------------+   +-------------------+
| - studentID: String                      |
| - universitySchool: String               |
| - budget: double                         |
| - isRenting: boolean                     |
| - currentRoom: Room                      |
| - leaseStartDate: String                 |
| - leaseEndDate: String                   |
| - monthlyRent: double                    |
| - paymentStatus: String                  |
+------------------------------------------+
| + Student(name, email, contactInfo,      |
|           address, studentID,            |
|           university, budget)            |
| + getStudentID(): String                 |
| + setStudentID(String): void             |
| + getUniversitySchool(): String          |
| + setUniversitySchool(String): void      |
| + getBudget(): double                    |
| + setBudget(double): void                |
| + isRenting(): boolean                   |
| + getCurrentRoom(): Room                 |
| + getLeaseStartDate(): String            |
| + getLeaseEndDate(): String              |
| + getMonthlyRent(): double               |
| + getPaymentStatus(): String             |
| + setPaymentStatus(String): void         |
| + bookRoom(Room, String, String,         |
|            double): void                 |
| + vacateRoom(): void                     |
| + payRent(): void                        |
| + browseListings(): void                 |
| + inquireRoom(DormListing): void         |
| + displayInfo(): String                  |  ◄─── POLYMORPHISM
+------------------------------------------+

+------------------------------------------+
|            Landlord 🏠                    |
+------------------------------------------+
| - landlordID: String                     |
| - ownedDorms: List<Dorm>                 |
+------------------------------------------+
| + Landlord(name, email, contactInfo,     |
|            address, landlordID)          |
| + getLandlordID(): String                |
| + setLandlordID(String): void            |
| + getOwnedDorms(): List<Dorm>            |
| + setOwnedDorms(List<Dorm>): void        |
| + addDorm(Dorm): void                    |
| + postDormListing(DormListing): void     |
| + updateListing(DormListing, String): void|
| + deleteListing(String): void            |
| + viewInquiries(List<Inquiry>): void     |
| + displayInfo(): String                  |  ◄─── POLYMORPHISM
+------------------------------------------+

+------------------------------------------+
|              Dorm 🏢                      |
+------------------------------------------+
| - dormName: String                       |
| - rooms: List<Room>                      |
| - googleMapLink: String                  |
| - address: String                        |
| - shortDescription: String               |
+------------------------------------------+
| + Dorm(dormName, googleMapLink,          |
|        address, shortDescription)        |
| + getDormName(): String                  |
| + setDormName(String): void              |
| + getRooms(): List<Room>                 |
| + setRooms(List<Room>): void             |
| + getGoogleMapLink(): String             |
| + setGoogleMapLink(String): void         |
| + getAddress(): String                   |
| + setAddress(String): void               |
| + getShortDescription(): String          |
| + setShortDescription(String): void      |
| + addRoom(Room): void                    |
| + getAvailableRooms(): List<Room>        |
| + getTotalRooms(): int                   |
| + displayInfo(): String                  |
+------------------------------------------+
               |
               | contains
               ▼
+------------------------------------------+
|              Room 🚪                      |
+------------------------------------------+
| - roomNumber: String                     |
| - capacity: int                          |
| - occupiedCount: int                     |
| - pricePerMonth: double                  |
| - isAvailable: boolean                   |
| - tenants: List<Student>                 |
+------------------------------------------+
| + Room(roomNumber, capacity,             |
|        pricePerMonth)                    |
| + getRoomNumber(): String                |
| + getCapacity(): int                     |
| + getOccupiedCount(): int                |
| + getPricePerMonth(): double             |
| + getTenants(): List<Student>            |
| + isAvailable(): boolean                 |
| + book(Student): boolean                 |
| + vacate(): void                         |
| + getOccupancyStatus(): String           |
| + displayInfo(): String                  |
+------------------------------------------+

+------------------------------------------+
|          DormListing 📋                   |
+------------------------------------------+
| - listingID: String                      |
| - dorm: Dorm                             |
| - landlord: Landlord                     |
| - datePosted: String                     |
| - status: String                         |
| - availableRooms: int                    |
| - photos: List<String>                   |
| - priceRange: double                     |
+------------------------------------------+
| + DormListing(listingID, dorm, landlord, |
|               datePosted, availableRooms,|
|               priceRange)                |
| + getListingID(): String                 |
| + setListingID(String): void             |
| + getDorm(): Dorm                        |
| + setDorm(Dorm): void                    |
| + getLandlord(): Landlord                |
| + setLandlord(Landlord): void            |
| + getDatePosted(): String                |
| + setDatePosted(String): void            |
| + getStatus(): String                    |
| + setStatus(String): void                |
| + getAvailableRooms(): int               |
| + setAvailableRooms(int): void           |
| + getPhotos(): List<String>              |
| + setPhotos(List<String>): void          |
| + getPriceRange(): double                |
| + setPriceRange(double): void            |
| + addPhoto(String): void              |
| + displayInfo(String): void              |
+------------------------------------------+

+------------------------------------------+
|           Inquiry 💬                      |
+------------------------------------------+
| - inquiryID: String                      |
| - student: Student                       |
| - listing: DormListing                   |
| - message: String                        |
| - dateInquired: String                   |
| - status: String                         |
+------------------------------------------+
| + Inquiry(inquiryID, student, listing,   |
|           message, dateInquired)         |
| + getInquiryID(): String                 |
| + setInquiryID(String): void             |
| + getStudent(): Student                  |
| + setStudent(Student): void              |
| + getListing(): DormListing              |
| + setListing(DormListing): void          |
| + getMessage(): String                   |
| + setMessage(String): void               |
| + getDateInquired(): String              |
| + setDateInquired(String): void          |
| + getStatus(): String                    |
| + setStatus(String): void                |
| + respond(String): void                  |
+------------------------------------------+
```

---

## 🔗 RELATIONSHIPS

```
Person (ABSTRACT)
   ├── Student (extends Person)
   └── Landlord (extends Person)

Landlord
   └── owns → List<Dorm>

Dorm
   └── contains → List<Room>

Room
   └── rents to → List<Student>

DormListing
   ├── references → Dorm
   └── posted by → Landlord

Inquiry
   ├── made by → Student
   └── about → DormListing
```

---

## 📝 KEY CHANGES FROM ORIGINAL

### ✅ REMOVED:
- ❌ **Tenant class** (merged into Student with rental state)

### ✅ ADDED to Student:
- `isRenting: boolean`
- `currentRoom: Room`
- `leaseStartDate: String`
- `leaseEndDate: String`
- `monthlyRent: double`
- `paymentStatus: String`
- `bookRoom()`, `vacateRoom()`, `payRent()` methods

### ✅ ADDED to DormListing:
- `photos: List<String>`
- `priceRange: double`
- `availableRooms: int`

### ✅ ADDED to Dorm:
- `googleMapLink: String`
- `shortDescription: String`
- `addRoom()`, `getAvailableRooms()`, `getTotalRooms()` methods

---

## 🎯 OOP PILLARS DEMONSTRATION

| Pillar | Where to Find |
|--------|---------------|
| **Encapsulation** | All private fields + public getters/setters in all classes |
| **Inheritance** | `Student extends Person`, `Landlord extends Person` |
| **Polymorphism** | `displayInfo()` overridden in Student and Landlord |
| **Abstraction** | `Person` is abstract with abstract `displayInfo()` method |

---

## ✅ READY FOR IMPLEMENTATION

All classes are now properly designed with:
- ✅ No duplicate classes (Tenant removed)
- ✅ Proper inheritance hierarchy
- ✅ Clear relationships between classes
- ✅ All 4 OOP pillars demonstrated
- ✅ Feasible for console/GUI implementation

Good luck! This design is realistic and shows all OOP concepts clearly. 🎓
```
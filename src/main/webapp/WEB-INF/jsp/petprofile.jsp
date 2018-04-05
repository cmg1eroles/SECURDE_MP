<!DOCTYPE html>
<html lang="en">
<head>
    <title>Boop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/general.css">
    <link rel="stylesheet" href="/resources/css/petprofile-style.css">
    <style>

    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="card text-center">
        <div class="img-holder">
            <img class="card-img-top"  src="https://images4.alphacoders.com/227/thumb-1920-22714.jpg" alt="Card image cap">
        </div>
        <div class="card-body" >
            <div class="row">
                <div class="col" id="col-titles">
                    <div class="text-md-left"> Type</div>
                    <div class="text-md-left"> Breed</div>
                    <div class="text-md-left"> Age</div>
                    <div class="text-md-left"> Status</div>
                    <div class="text-md-left"> Medical Vaccines</div>
                    <div class="text-md-left"> Special Conditions</div>
                </div>
                <div class="col">
                    <div class="text-md-left" id="type"> Dog</div>
                    <div class="text-md-left" id="breed"> Corgi</div>
                    <div class="text-md-left" id="age"> 1 year</div>
                    <div class="text-md-left" id="status"> In the Pound</div>
                    <div class="text-md-left" id="vaccines"> Complete </div>
                    <div class="text-md-left" id="speccond"> None</div>
                </div>
            </div>
            <button class="btn btn-primary" data-toggle="modal" data-target="#cond-modal">Adopt Animal</button>
        </div>
    </div>
</div>
<!-- Terms and Condition -->
<div class="modal fade" id="cond-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Terms and Conditions</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p> 1. Any information concerning the habits and past history of the Animal is passed on by the RSPCA to the Adopter in       good faith. This information has been provided to assist with the adoption process and successful adoption of the         Animal which may have come to the RSPCA’s care for example, by being signed over by the Animal’s previous owner, found     abandoned, lost and of unknown background.
                    The information we provide you may be based on statements made by the previous owner or the RSPCA Inspectorate and/or
                    assessments or observations of the animal whilst in the RSPCA’s care. We cannot guarantee that this information is correct despite
                    making every effort being made. Please see www.rspca.org.uk/findapet/rehomeapet/process for our rehoming policy.
                </p>
                <p>
                    2. The Animal is believed to be in normal health on leaving the animal establishment except where specific conditions have been made
                    known to the Adopter on the Animal Adoption Form and the responsibility for and cost of any future veterinary or other treatment shall
                    be borne solely by the Adopter save where Clause 4 applies.
                </p>
                <p>
                    3. The animal’s welfare is our priority and we will work with you to resolve any concerns or questions you have in respect of the Animal
                    after adoption and we ask you to contact the RSPCA branch or animal centre where you adopted the animal giving full details as soon
                    as possible.
                </p>
                <p>
                    4. Nothing in these terms will affect your legal rights including those under the Consumer Rights Act 2015 (and other consumer protection
                    laws). Please contact your local Consumer Advice or Trading Standards Department for more information about this.
                </p>
                <p>
                    5. The RSPCA strongly advises the Adopter to arrange appropriate insurance cover against risks referred to in this Agreement and also
                    the costs of veterinary treatment.
                </p>
                <p>
                    6. The Adopter confirms that to the best of their knowledge and belief no person residing in their household, or who will care for the
                    Animal, is disqualified from keeping animals or has had a deprivation order made under the Animal Welfare Act 2006 and/or has an
                    unspent conviction for offences relating to animals.
                </p>
                <p>
                    7. Attention is drawn to the possible liability of the Adopter for damage and injury which they may cause to third parties or their property. In
                    particular liability may arise under the Animals Act 1971. The possibility of an action for nuisance against the Adopter as a result of the
                    Animal’s behaviour should also be recognised. The RSPCA strongly advises the Adopter to arrange appropriate insurance cover
                    against risks referred to in this Agreement and also the costs of veterinary treatment.
                </p>
                <p>
                    8. The Adopter agrees to comply with all relevant regulations, legislation and laws concerning the welfare, control, responsible ownership
                    and protection of animals including without limitation the Animal Welfare Act 2006 and Codes of Practice issued in England and Wales
                    under the 2006 Act and to ensure that anyone with the temporary care of the Animal also complies The welfare needs of the animal
                    means providing for the animal’s health, happiness and taking measures to ensure that the animal’s health is maintained, in that he/she
                    is properly housed, fed, watered, socialised and exercised and receives appropriate veterinary care, including vaccination, regular
                    worming and flea treatment, as appropriate to the species.
                </p>
                <p>
                    9. If a dog, cat, rabbit, ferret, male guinea pig or male horse is unneutered at the time of adoption, the Adopter agrees to having the Animal
                    neutered as soon as possible unless there are overriding veterinary reasons for it not being possible.
                </p>
                <p>
                    10. When adopting a dog, cat, rabbit, ferret or horse (or any other microchipped animal), the adopter agrees for their personal data to be
                    passed to the microchip database by the RSPCA for the purposes of registering the microchip. The Adopter agrees to maintain the
                    microchip records of the animal, by informing the microchip database of any changes of address or ownership of the animal postadoption.
                    This also applies to Equine Passports, where your personal details will be passed to the passport issuing authority.
                </p>
                <p>
                    11. The Adopter agrees not to irresponsibly sell or part with the animal.
                </p>
                <p>
                    12. Nothing in this Agreement shall exclude or in any way limit the RSPCA’s liability for fraud, or for the death or personal injury caused by
                    its negligence or any other liability or consumer rights which it cannot legally exclude or limit.
                </p>
                <p>
                    13. This Agreement is between the Adopter and the RSPCA and no other party has the right to enforce the terms of this Agreement
                </p>
                <p>
                    14. If court or relevant authority finds any part of this Agreement to be unenforceable, the rest of the Agreement shall continue in force as
                    each of these terms operates separately.
                </p>
                <p>
                    15. The English and Welsh Courts will have exclusive jurisdiction over any claim arising from or related to this Agreement. English and Welsh law will apply to this Agreement.
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#reserve-modal">
                    Accept Terms and Conditions</button>
            </div>
        </div>
    </div>
</div>
<!-- Reserve Modal -->
<div class="modal fade" id="reserve-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label >Pick up Date</label>
                        <input type="datetime-local" class="form-control" id="date"placeholder="yyyy-mm-dd">
                    </div>
                    <button type="submit" class="btn btn-primary" data-dismiss="modal" id="rsv-submit">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Login Modal -->
<jsp:include page="login.jsp" />
<!--Register Modal -->
<jsp:include page="register.jsp" />
</body>
</html>

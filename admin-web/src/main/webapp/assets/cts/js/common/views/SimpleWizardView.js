(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.views.SimpleWizardView', ['common.views.InputAwareViewWithValidation'], factory);
    } else {
        factory();
    }
})(
    function(InputAwareViewWithValidation) {

        /**
         * Simple view wizard with steps, parsley validation.
         * 1) Specify steps as html classes, and use them in view template.
         * 2) Use specified .btnPrev and .btnNext to switch step.
         * 3) Use specified .text-info, .text-danger, text-success to view text messages.
         * 4) Use parsley to validate fields if need.
         * 5) Override _changeStep to control all actions of steps.
         */
        return InputAwareViewWithValidation.extend({
            attributes: {
                "data-parsley-validate": true,
                "data-parsley-excluded": "input.hidden"
            },
            initBeforeRender: function(opts) {
                this.steps = opts.steps;
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function() {
                this.currentStep = this.steps[0];

                this.$info = this.$el.find(".text-info");
                this.$error = this.$el.find(".text-danger");
                this.$success = this.$el.find(".text-success");

                this.addEvent("click .btnPrev", function() {
                    this._changeStep({ isNext: false })
                });
                this.addEvent("click .btnNext", function() {
                    this._changeStep({ isNext: true })
                });
                this.addEvent("keyup input", function(e) {
                    if (e.which === 13) { // enter key
                        this._changeStep({ isNext: true });
                    }
                });

                this.superInitAfterRender(InputAwareViewWithValidation);
                this.delegateEvents();
            },
            _changeStep: function(opts) {
                if (opts.isNext && !this.validateInputs()) {
                    return;
                }
                this.$info.empty();
                this.$error.empty();
                this.$success.empty();

                // Если находимся на первом step, и хотим перейти на предыдущй, то не переходим, а переходим на другой View.
                var doNotChangeStep = !opts.isNext && this.isFirstStep();

                if (this.changeStep(opts) && !doNotChangeStep) {
                    // Если последний шаг, то сбрасываем на первый, что бы потом при переходе на этот wizard попали на первый шаг.
                    if (this.isLastStep()) {
                        this.currentStep = this.steps[0];
                    } else {
                        this.currentStep = this.steps[this.steps.indexOf(this.currentStep) + (opts.isNext ? 1 : -1)];
                    }
                    this.goToStep(this.currentStep);
                }
            },
            changeStep: function(opts) {
                // Override to control all actions of steps
                return true;
            },
            goToStep: function(step) {
                this.currentStep = step;
                this.$el.find("[class*=step-]").addClass("hidden");
                this.$el.find("." + step).removeClass("hidden");
                this.$el.find('input:visible:first').focus();
            },
            isFirstStep: function() {
                return this.steps.indexOf(this.currentStep) == 0;
            },
            isLastStep: function() {
                return _.last(this.steps) == this.currentStep;
            }
        });
    }
);